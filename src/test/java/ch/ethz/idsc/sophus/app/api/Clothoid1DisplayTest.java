// code by jph
package ch.ethz.idsc.sophus.app.api;

import ch.ethz.idsc.sophus.crv.clothoid.Clothoid1;
import junit.framework.TestCase;

public class Clothoid1DisplayTest extends TestCase {
  public void testSimple() {
    assertEquals(Clothoid1Display.INSTANCE.geodesicInterface(), Clothoid1.INSTANCE);
  }
}