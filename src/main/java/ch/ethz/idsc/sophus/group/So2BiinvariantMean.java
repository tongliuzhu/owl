// code by jph
package ch.ethz.idsc.sophus.group;

import ch.ethz.idsc.sophus.AffineQ;
import ch.ethz.idsc.sophus.math.BiinvariantMeanInterface;
import ch.ethz.idsc.sophus.planar.ArcTan2D;
import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.lie.AngleVector;

public enum So2BiinvariantMean implements BiinvariantMeanInterface {
  INSTANCE;
  // ---
  // /** maps to the interval [-pi, pi) */
  // private static final Mod MOD_DISTANCE = Mod.function(Pi.TWO, Pi.VALUE.negate());
  @Override // from BiinvariantMeanInterface
  public Tensor mean(Tensor sequence, Tensor weights) {
    // Scalar a1 = Mean.of(sequence).Get();
    // Scalar amean = a1.subtract(weights.dot(sequence.map(a1::subtract).map(MOD_DISTANCE)));
    // System.out.println(amean);
    return ArcTan2D.of(AffineQ.require(weights).dot(sequence.map(AngleVector::of)));
  }
}
