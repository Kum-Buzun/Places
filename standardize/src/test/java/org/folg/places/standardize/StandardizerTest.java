package org.folg.places.standardize;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StandardizerTest {
   Standardizer standardizer;

   @Before
   public void setUp() {
      standardizer = Standardizer.getInstance();
   }

   @Test
   public void testStandardizer() {
      assertEquals("Philadelphia, Philadelphia, Pennsylvania, United States", standardizer.standardize("Philly, PA").getFullName());
      assertEquals("Philadelphia, Philadelphia, Pennsylvania, United States", standardizer.standardize("South Philly, PA").getFullName());
   }

   @Test
   public void testDefaultCountry() {
      assertEquals("South, Covington, Alabama, United States", standardizer.standardize("South Covington").getFullName());
      assertEquals("Covington, Huntingdonshire, England", standardizer.standardize("South Covington", "England").getFullName());
      assertEquals("Covington, Huntingdonshire, England", standardizer.standardize("South Covington", "United Kingdom").getFullName());
   }
}
