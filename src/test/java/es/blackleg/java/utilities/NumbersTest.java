/*
 * Copyright 2015 hector.
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
public class NumbersTest {
    
    public NumbersTest() {
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
     * Test of isInt method, of class Numbers.
     */
    @Test
    public void testIsInt() {
        String number = "15";
        assertTrue(Numbers.isInt(number));
        String noNumber = "Pepe";
        assertFalse(Numbers.isInt(noNumber));
    }
    
    @Test
    public void testRoundDouble() {
        double initial = 100.12345;
        double compare = 100.12;
        double result = Numbers.simpleRoundDouble(initial);
        assertEquals(compare, result, 0.0);

    }
    
}
