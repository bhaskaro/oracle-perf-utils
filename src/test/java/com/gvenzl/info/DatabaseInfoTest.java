/*
* author:  gvenzl
* created: 23 Dec 2016
*/

package com.gvenzl.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseInfoTest {
	
	private Connection conn;
	private static final String user = "test";
	private static final String password = "test";
	private static final String host = "localhost";
	private static final String port = "1521";
	private static final String service = "ORCLPDB1";	
	@Before
	public void setup() throws SQLException {
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:" + user + "/" + password + "@//" + host + ":" + port + "/" + service);
	}
	
	@Test
	public void test_instantiation() throws SQLException {
		System.out.println("test_instantiation()");
		new DatabaseInfo(conn);
	}
	
	@Test
	public void test_getCharacterSet() throws SQLException {
		System.out.println("test_getCharacterSet()");
		DatabaseInfo dbInfo = new DatabaseInfo(conn);
		String expected = "AL32UTF8";
		Assert.assertEquals(expected, dbInfo.getCharacterSet());
	}

	@Test
	public void test_getDBName() throws SQLException {
		System.out.println("test_getDBName()");
		DatabaseInfo dbInfo = new DatabaseInfo(conn);
		String expected = "ORCLCDB";
		Assert.assertEquals(expected, dbInfo.getDBName());
	}

	@Test
	public void test_getPlatformName() throws SQLException {
		System.out.println("test_getPlatformName()");
		DatabaseInfo dbInfo = new DatabaseInfo(conn);
		String expected = "Linux x86 64-bit";
		Assert.assertEquals(expected, dbInfo.getPlatformName());
	}

	@Test
	public void test_getVersion() throws SQLException {
		System.out.println("test_getVersion()");
		DatabaseInfo dbInfo = new DatabaseInfo(conn);
		String expected = "Oracle Database 12c Enterprise Edition Release 12.1.0.2.0 - 64bit Production";
		Assert.assertEquals(expected, dbInfo.getVersion());
	}
	
	@Test
	public void test_isCDB() throws SQLException {
		System.out.println("test_isCDB()");
		DatabaseInfo dbInfo = new DatabaseInfo(conn);
		System.out.println(dbInfo.isCDB());
		Assert.assertTrue(dbInfo.isCDB());
	}
}
