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

package org.openmrs.module.chaicore.converter;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.module.chaicore.UiResource;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.is;

/**
 * Tests for {@link StringToUiResourceConverter}
 */
public class StringToUiResourceConverterTest extends BaseModuleContextSensitiveTest {

	@Autowired
	private StringToUiResourceConverter converter;

	@Test
	public void convert() {
		UiResource resource1 = converter.convert("chaicore:test/test.res");
		Assert.assertThat(resource1.getProvider(), is("chaicore"));
		Assert.assertThat(resource1.getPath(), is("test/test.res"));

		// Empty strings should convert to nulls
		Assert.assertNull(converter.convert(null));
		Assert.assertNull(converter.convert(""));
	}

	@Test(expected = IllegalArgumentException.class)
	public void convert_shouldThrowExceptionIfNoColons() {
		converter.convert("chaicore/test.res");
	}

	@Test(expected = IllegalArgumentException.class)
	public void convert_shouldThrowExceptionIfMoreThanTwoColons() {
		converter.convert("chaicore:test:test.res");
	}
}