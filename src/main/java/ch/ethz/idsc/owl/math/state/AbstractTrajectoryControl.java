// code by jph
package ch.ethz.idsc.owl.math.state;

import java.util.Optional;

import ch.ethz.idsc.tensor.Scalar;
import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.sca.N;

public abstract class AbstractTrajectoryControl implements TrajectoryControl {
  private final Tensor fallback;

  /** @param fallback control */
  public AbstractTrajectoryControl(Tensor fallback) {
    this.fallback = N.DOUBLE.of(fallback).unmodifiable();
  }

  @Override
  public final Tensor control(StateTime tail, Scalar now) {
    Optional<Tensor> optional = protected_control(tail, now);
    return optional.isPresent() ? optional.get() : fallback;
  }

  protected abstract Optional<Tensor> protected_control(StateTime tail, Scalar now);
}
