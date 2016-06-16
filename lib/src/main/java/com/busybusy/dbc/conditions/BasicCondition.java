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
import com.busybusy.dbc.DbcBlock;
import com.busybusy.dbc.checks.BasicChecks;

import org.jetbrains.annotations.NonNls;

import java.util.Comparator;

/**
 * Basic checks on any java object
 *
 * @param <T> type of object
 * @author Trevor
 */
@NonNls
public class BasicCondition<T> implements BasicChecks<T>
{
	protected final T subject;

	public BasicCondition(T subject) {this.subject = subject;}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNull()
	{
		if (this.subject != null)
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("A null argument was required but was:" + this.subject));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNotNull()
	{
		if (this.subject == null)
		{
			DbcAssertionException.throwNew(new NullPointerException("A non null argument was required but was null"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void passes(DbcBlock<T> testBlock)
	{
		if (!testBlock.checkState(this.subject))
		{
			DbcAssertionException.throwNew(new IllegalStateException("Assertion in <" + testBlock + "> failed on subject: " + this.subject));
		}
	}

	@Override
	public void isEqualTo(T toCompare)
	{

	}

	@Override
	public void isEqualTo(T toCompare, Comparator<T> customComparator)
	{

	}
}
