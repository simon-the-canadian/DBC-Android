/*
 * Copyright 2016 Busy, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.busybusy.dbc;

import com.busybusy.dbc.conditions.BasicCondition;
import com.busybusy.dbc.conditions.DoubleCondition;
import com.busybusy.dbc.conditions.FloatCondition;
import com.busybusy.dbc.conditions.IntegralCondition;
import com.busybusy.dbc.conditions.ListCondition;
import com.busybusy.dbc.conditions.MapCondition;
import com.busybusy.dbc.conditions.ObjectCondition;
import com.busybusy.dbc.conditions.StringCondition;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class DbcTest
{
	@Test
	public void requireObject() throws Exception
	{
		testMethod(Dbc::require, new Object(), ObjectCondition.class);
	}

	@Test
	public void requireDouble() throws Exception
	{
		testMethod(Dbc::require, 2.0D, DoubleCondition.class);
	}

	@Test
	public void requireFloat() throws Exception
	{
		testMethod(Dbc::require, 2.0F, FloatCondition.class);
	}

	@Test
	public void requireInteger() throws Exception
	{
		testMethod(Dbc::require, 2, IntegralCondition.class);
	}

	@Test
	public void requireLong() throws Exception
	{
		testMethod(Dbc::require, 2L, IntegralCondition.class);
	}

	@Test
	public void requireList() throws Exception
	{
		testMethod(Dbc::require, new ArrayList<>(), ListCondition.class);
	}

	@Test
	public void requireMap() throws Exception
	{
		testMethod(Dbc::require, new HashMap<>(), MapCondition.class);
	}

	@Test
	public void requireString() throws Exception
	{
		testMethod(Dbc::require, "String", StringCondition.class);
	}

	@Test
	public void checkObject() throws Exception
	{
		testMethod(Dbc::check, new Object(), ObjectCondition.class);
	}

	@Test
	public void checkDouble() throws Exception
	{
		testMethod(Dbc::check, 2.0D, DoubleCondition.class);
	}

	@Test
	public void checkFloat() throws Exception
	{
		testMethod(Dbc::check, 2.0F, FloatCondition.class);
	}

	@Test
	public void checkInteger() throws Exception
	{
		testMethod(Dbc::check, 2, IntegralCondition.class);
	}

	@Test
	public void checkLong() throws Exception
	{
		testMethod(Dbc::check, 2L, IntegralCondition.class);
	}

	@Test
	public void checkList() throws Exception
	{
		testMethod(Dbc::check, new ArrayList<>(), ListCondition.class);
	}

	@Test
	public void checkMap() throws Exception
	{
		testMethod(Dbc::check, new HashMap<>(), MapCondition.class);
	}

	@Test
	public void checkString() throws Exception
	{
		testMethod(Dbc::check, "String", StringCondition.class);
	}

	@Test
	public void ensureObject() throws Exception
	{
		testMethod(Dbc::ensure, new Object(), ObjectCondition.class);
	}

	@Test
	public void ensureDouble() throws Exception
	{
		testMethod(Dbc::ensure, 2.0D, DoubleCondition.class);
	}

	@Test
	public void ensureFloat() throws Exception
	{
		testMethod(Dbc::ensure, 2.0F, FloatCondition.class);
	}

	@Test
	public void ensureInteger() throws Exception
	{
		testMethod(Dbc::ensure, 2, IntegralCondition.class);
	}

	@Test
	public void ensureLong() throws Exception
	{
		testMethod(Dbc::ensure, 2L, IntegralCondition.class);
	}

	@Test
	public void ensureList() throws Exception
	{
		testMethod(Dbc::ensure, new ArrayList<>(), ListCondition.class);
	}

	@Test
	public void ensureMap() throws Exception
	{
		testMethod(Dbc::ensure, new HashMap<>(), MapCondition.class);
	}

	@Test
	public void ensureString() throws Exception
	{
		testMethod(Dbc::ensure, "String", StringCondition.class);
	}

	private interface Func<ParamType, ReturnType>
	{
		ReturnType apply(ParamType param);
	}

	private <T, R extends BasicCondition> void testMethod(Func<T, ? extends R> method, T target, Class<? extends R> expectedResult) throws Exception
	{
		testMethodReturnsType(method, target, expectedResult);
	}

	private <T, R extends BasicCondition> void testMethodReturnsType(Func<T, ? extends R> method, T target, Class<? extends R> expectedResult) throws Exception
	{
		R result = method.apply(target);
		assertThat(result).isInstanceOf(expectedResult);
	}

}