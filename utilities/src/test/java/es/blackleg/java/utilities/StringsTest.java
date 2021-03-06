/*
 * Copyright 2016 hector.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.blackleg.java.utilities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hector
 */
public class StringsTest {
    
    public StringsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of cortarPorAtras method, of class Strings.
     */
    @Test
    public void testCortarPorAtras() {
        String string = "PEPEpepe";
        int count = 4;
        String expResult = "pepe";
        String result = Strings.cortarPorAtras(string, count);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckIfIsEmptyOrNull() {
        String test = "Pepe";
        assertFalse(Strings.checkIfIsEmptyOrNull(test));
        test = "";
        assertTrue(Strings.checkIfIsEmptyOrNull(test));
        test = null;
        assertTrue(Strings.checkIfIsEmptyOrNull(test));
    }
    
    @Test
    public void testCheckIfIsNotEmptyOrNull() {
        String test = "Pepe";
        assertTrue(Strings.checkIfIsNotEmptyOrNull(test));
        test = "";
        assertFalse(Strings.checkIfIsNotEmptyOrNull(test));
        test = null;
        assertFalse(Strings.checkIfIsNotEmptyOrNull(test));
    }
    
}
