/**
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. 
 * If a copy of the MPL was not distributed with this file,
 * you can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.jopss.logico.negocio.util;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jopss.logico.exception.CaptchaLogicoException;
import com.jopss.logico.modelos.Erro;

import com.googlecode.flyway.core.Flyway;

/**
 * Fabrica de conexoes JPA com o banco de dados. Cria a 'EntityManagerFactory'
 * como Singleton. Faz ainda a gerencia das migrations do FlyWay.
 * 
 * @author jopss
 */
public class GerenciadorBase {

	private static EntityManagerFactory factory;

	public GerenciadorBase() throws CaptchaLogicoException {
		GerenciadorBase.factory = this.getFactory();
	}

	/**
	 * Retorna a fabrica de EntityManager da JPA, e inicializa o FlyWay para
	 * verificacao de migrations SQL.
	 *
	 * @return EntityManagerFactory
	 */
	private EntityManagerFactory getFactory() {
		if (factory == null) {
			Properties propsBase = new Properties();

			try {
				propsBase.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("captcha_db.properties"));
			} catch (IOException e) {
				throw new CaptchaLogicoException(Erro.ERRO_005, e);
			}

			factory = Persistence.createEntityManagerFactory("captcha_logico_pu", propsBase);

			Properties properties = new Properties();
			properties.setProperty("flyway.user", propsBase.getProperty("hibernate.connection.username"));
			properties.setProperty("flyway.password", propsBase.getProperty("hibernate.connection.password"));
			properties.setProperty("flyway.url", propsBase.getProperty("hibernate.connection.url"));
			properties.setProperty("flyway.driver", propsBase.getProperty("hibernate.connection.driver_class"));

			Flyway flyway = new Flyway();
			flyway.configure(properties);
			flyway.setLocations("cp/migrations");
			flyway.setSqlMigrationPrefix("CPLOG_");
			flyway.migrate();
		}
		return factory;
	}

	/**
	 * Retorna um EntityManager JPA valido.
	 *
	 * @return EntityManager
	 */
	public EntityManager getConnect() {
		return this.getFactory().createEntityManager();
	}
}
