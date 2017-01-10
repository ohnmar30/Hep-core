/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.chaicore;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

/**
 * Tests for {@link UiResource}
 */
public class UiResourceTest {

	@Test(expected = IllegalArgumentException.class)
	public void constructor_shouldThrowExceptionIfNoColons() {
		new UiResource("chaicore/test.xml");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructor_shouldThrowExceptionIfMoreThanTwoColons() {
		new UiResource("chaicore:test:test.xml");
	}

	@Test
	public void constructor_shouldConstructWithBothParameters() {
		UiResource res = new UiResource("chaicore", "test.xml");
		Assert.assertThat(res.getProvider(), is("chaicore"));
		Assert.assertThat(res.getPath(), is("test.xml"));
	}

	@Test
	public void getProvider_shouldGetProvider() {
		Assert.assertThat(new UiResource("chaicore:test.xml").getProvider(), is("chaicore"));
	}

	@Test
	public void getPath_shouldGetPath() {
		Assert.assertThat(new UiResource("chaicore:test.xml").getPath(), is("test.xml"));
	}

	@Test
	public void toString_shouldConcatWithColon() {
		Assert.assertThat(new UiResource("chaicore:test.xml").toString(), is("chaicore:test.xml"));
	}

	@Test
	public void equals_shouldCheckEquality() {
		Assert.assertThat(new UiResource("chaicore:test.xml"), is(new UiResource("chaicore:test.xml")));
		Assert.assertThat(new UiResource("chaicore:test.xml"), is(not(new UiResource("chaicore:xxx.xml"))));
		Assert.assertThat(null, is(not(new UiResource("chaicore:test.xml"))));
	}

	@Test
	public void hashCode_shouldReturnSuitableHashCode() {
		// Same for equal objects
		Assert.assertThat(new UiResource("chaicore:test.xml").hashCode(), is(new UiResource("chaicore:test.xml").hashCode()));
	}
}