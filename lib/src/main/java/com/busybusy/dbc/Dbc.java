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

import com.busybusy.dbc.conditions.DoubleCondition;
import com.busybusy.dbc.conditions.FloatCondition;
import com.busybusy.dbc.conditions.IntegralCondition;
import com.busybusy.dbc.conditions.ListCondition;
import com.busybusy.dbc.conditions.MapCondition;
import com.busybusy.dbc.conditions.ObjectCondition;
import com.busybusy.dbc.conditions.StringCondition;

import java.util.List;
import java.util.Map;

/**
 * In debug code, the following methods assist in using "Design by contract" in java
 * <p>
 * In non-debug code, these methods can be stripped out via the provided progaurd config file
 *
 * @author Trevor
 * @see <a href="https://en.wikipedia.org/wiki/Design_by_contract">Wikipedia : Design by Contract</a>
 */
public class Dbc
{
	private Dbc() {}

	public static <T> ObjectCondition require(T subject)
	{
		return new ObjectCondition(subject);
	}

	public static DoubleCondition require(Double subject)
	{
		return new DoubleCondition(subject);
	}

	public static FloatCondition require(Float subject)
	{
		return new FloatCondition(subject);
	}

	public static IntegralCondition<Integer> require(Integer subject)
	{
		return new IntegralCondition<>(subject);
	}

	public static IntegralCondition<Long> require(Long subject)
	{
		return new IntegralCondition<>(subject);
	}

	public static <T extends List<E>, E> ListCondition<T, E> require(T subject)
	{
		return new ListCondition<>(subject);
	}

	public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> require(T subject)
	{
		return new MapCondition<>(subject);
	}

	public static StringCondition require(String subject)
	{
		return new StringCondition(subject);
	}

	public static <T> ObjectCondition check(T subject)
	{
		return new ObjectCondition(subject);
	}

	public static DoubleCondition check(Double subject)
	{
		return new DoubleCondition(subject);
	}

	public static FloatCondition check(Float subject)
	{
		return new FloatCondition(subject);
	}

	public static IntegralCondition<Integer> check(Integer subject)
	{
		return new IntegralCondition<>(subject);
	}

	public static IntegralCondition<Long> check(Long subject)
	{
		return new IntegralCondition<>(subject);
	}

	public static <T extends List<E>, E> ListCondition<T, E> check(T subject)
	{
		return new ListCondition<>(subject);
	}

	public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> check(T subject)
	{
		return new MapCondition<>(subject);
	}

	public static StringCondition check(String subject)
	{
		return new StringCondition(subject);
	}

	public static <T> ObjectCondition ensure(T subject)
	{
		return new ObjectCondition(subject);
	}

	public static DoubleCondition ensure(Double subject)
	{
		return new DoubleCondition(subject);
	}

	public static FloatCondition ensure(Float subject)
	{
		return new FloatCondition(subject);
	}

	public static IntegralCondition<Integer> ensure(Integer subject)
	{
		return new IntegralCondition<>(subject);
	}

	public static IntegralCondition<Long> ensure(Long subject)
	{
		return new IntegralCondition<>(subject);
	}

	public static <T extends List<E>, E> ListCondition<T, E> ensure(T subject)
	{
		return new ListCondition<>(subject);
	}

	public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> ensure(T subject)
	{
		return new MapCondition<>(subject);
	}

	public static StringCondition ensure(String subject)
	{
		return new StringCondition(subject);
	}
}
