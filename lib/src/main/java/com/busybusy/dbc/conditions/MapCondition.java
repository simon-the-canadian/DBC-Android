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

package com.busybusy.dbc.conditions;

import com.busybusy.dbc.DbcAssertionException;
import com.busybusy.dbc.checks.MapChecks;

import java.util.Map;

/**
 * {@linkplain MapChecks} primary implementation
 *
 * @author Trevor
 */
public final class MapCondition<T extends Map<K, V>, K, V> extends BasicCondition<T, MapCondition<T, K, V>> implements MapChecks<T, K, V, MapCondition<T, K, V>>
{
	public MapCondition(T subject, boolean enabled) { super(subject, enabled); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> isNotEmpty()
	{
		this.isNotNull();

		if (this.enabled && this.subject.isEmpty())
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected non empty map"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> hasSize(int size)
	{
		this.isNotNull();

		if (this.enabled && !(this.subject.size() == size))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected map size to be <" + size + "> but was <" + this.subject.size() + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> hasSizeBetween(int startInclusive, int endInclusive)
	{
		this.isNotNull();

		int mapSize = this.subject.size();
		if (this.enabled && !((mapSize >= startInclusive && mapSize <= endInclusive) || (mapSize <= startInclusive && mapSize >= endInclusive)))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected map size to be between <" + startInclusive + "> and < " + endInclusive + "> but was <" + mapSize + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> containsKey(K key)
	{
		this.isNotNull();

		if (this.enabled && !this.subject.containsKey(key))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected map to contain key: " + key));
		}

		return this;
	}
}
