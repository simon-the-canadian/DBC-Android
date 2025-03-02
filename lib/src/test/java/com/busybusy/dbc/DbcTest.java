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

import android.os.Bundle;

import com.busybusy.dbc.conditions.BasicCondition;
import com.busybusy.dbc.conditions.BooleanCondition;
import com.busybusy.dbc.conditions.BundleCondition;
import com.busybusy.dbc.conditions.DoubleCondition;
import com.busybusy.dbc.conditions.FloatCondition;
import com.busybusy.dbc.conditions.IntegralCondition;
import com.busybusy.dbc.conditions.ListCondition;
import com.busybusy.dbc.conditions.MapCondition;
import com.busybusy.dbc.conditions.ObjectCondition;
import com.busybusy.dbc.conditions.SetCondition;
import com.busybusy.dbc.conditions.StringCondition;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Trevor
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 23)
public class DbcTest
{
	@Test
	public void requireObject() throws Exception
	{
		testMethod(Dbc::require, new Object(), ObjectCondition.class);
	}

	@Test
	public void requireBoolean() throws Exception
	{
		testMethod(Dbc::require, true, BooleanCondition.class);
	}

	@Test
	public void requireBundle() throws Exception
	{
		testMethod(Dbc::require, new Bundle(), BundleCondition.class);
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
	public void requireArray() throws Exception
	{
		testMethod(Dbc::require, new Integer[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void requirePrimArrayInt() throws Exception
	{
		testMethod(Dbc::require, new int[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void requirePrimArrayShort() throws Exception
	{
		testMethod(Dbc::require, new short[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void requirePrimArrayLong() throws Exception
	{
		testMethod(Dbc::require, new long[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void requirePrimArrayFloat() throws Exception
	{
		testMethod(Dbc::require, new float[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void requirePrimArrayDouble() throws Exception
	{
		testMethod(Dbc::require, new double[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void requirePrimArrayBoolean() throws Exception
	{
		testMethod(Dbc::require, new boolean[]{true, false, true}, ListCondition.class);
	}

	@Test
	public void requirePrimArrayChar() throws Exception
	{
		testMethod(Dbc::require, new char[]{'1', '2', '3'}, ListCondition.class);
	}

	@Test
	public void requirePrimArrayByte() throws Exception
	{
		testMethod(Dbc::require, new byte[]{'1', '2', '3'}, ListCondition.class);
	}

	@Test
	public void requireMap() throws Exception
	{
		testMethod(Dbc::require, new HashMap<>(), MapCondition.class);
	}

	@Test
	public void requireSet() throws Exception
	{
		testMethod(Dbc::require, new HashSet<>(), SetCondition.class);
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
	public void checkBoolean() throws Exception
	{
		testMethod(Dbc::check, true, BooleanCondition.class);
	}

	@Test
	public void checkBundle() throws Exception
	{
		testMethod(Dbc::check, new Bundle(), BundleCondition.class);
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
	public void checkArray() throws Exception
	{
		testMethod(Dbc::check, new Integer[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void checkPrimArrayInt() throws Exception
	{
		testMethod(Dbc::check, new int[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void checkPrimArrayShort() throws Exception
	{
		testMethod(Dbc::check, new short[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void checkPrimArrayLong() throws Exception
	{
		testMethod(Dbc::check, new long[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void checkPrimArrayFloat() throws Exception
	{
		testMethod(Dbc::check, new float[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void checkPrimArrayDouble() throws Exception
	{
		testMethod(Dbc::check, new double[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void checkPrimArrayBoolean() throws Exception
	{
		testMethod(Dbc::check, new boolean[]{true, false, true}, ListCondition.class);
	}

	@Test
	public void checkPrimArrayChar() throws Exception
	{
		testMethod(Dbc::check, new char[]{'1', '2', '3'}, ListCondition.class);
	}

	@Test
	public void checkPrimArrayByte() throws Exception
	{
		testMethod(Dbc::check, new byte[]{'1', '2', '3'}, ListCondition.class);
	}

	@Test
	public void checkMap() throws Exception
	{
		testMethod(Dbc::check, new HashMap<>(), MapCondition.class);
	}

	@Test
	public void checkSet() throws Exception
	{
		testMethod(Dbc::check, new HashSet<>(), SetCondition.class);
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
	public void ensureBoolean() throws Exception
	{
		testMethod(Dbc::ensure, true, BooleanCondition.class);
	}

	@Test
	public void ensureBundle() throws Exception
	{
		testMethod(Dbc::ensure, new Bundle(), BundleCondition.class);
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
	public void ensureArray() throws Exception
	{
		testMethod(Dbc::ensure, new Integer[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void ensurePrimArrayInt() throws Exception
	{
		testMethod(Dbc::ensure, new int[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void ensurePrimArrayShort() throws Exception
	{
		testMethod(Dbc::ensure, new short[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void ensurePrimArrayLong() throws Exception
	{
		testMethod(Dbc::ensure, new long[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void ensurePrimArrayFloat() throws Exception
	{
		testMethod(Dbc::ensure, new float[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void ensurePrimArrayDouble() throws Exception
	{
		testMethod(Dbc::ensure, new double[]{1, 2, 3}, ListCondition.class);
	}

	@Test
	public void ensurePrimArrayBoolean() throws Exception
	{
		testMethod(Dbc::ensure, new boolean[]{true, false, true}, ListCondition.class);
	}

	@Test
	public void ensurePrimArrayChar() throws Exception
	{
		testMethod(Dbc::ensure, new char[]{'1', '2', '3'}, ListCondition.class);
	}

	@Test
	public void ensurePrimArrayByte() throws Exception
	{
		testMethod(Dbc::ensure, new byte[]{'1', '2', '3'}, ListCondition.class);
	}

	@Test
	public void ensureMap() throws Exception
	{
		testMethod(Dbc::ensure, new HashMap<>(), MapCondition.class);
	}

	@Test
	public void ensureSet() throws Exception
	{
		testMethod(Dbc::ensure, new HashSet<>(), SetCondition.class);
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
