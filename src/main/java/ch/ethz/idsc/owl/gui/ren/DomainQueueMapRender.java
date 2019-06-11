// code by jph 
package ch.ethz.idsc.owl.gui.ren;

import java.awt.Color;
import java.util.Map;

import ch.ethz.idsc.owl.glc.rl2.RelaxedPriorityQueue;
import ch.ethz.idsc.owl.math.planar.Extract2D;
import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.img.ColorDataIndexed;
import ch.ethz.idsc.tensor.img.ColorDataLists;

public class DomainQueueMapRender extends DomainRender {
  private static final ColorDataIndexed INTERIOR = ColorDataLists._097.cyclic().deriveWithAlpha(128);
  // ---
  private final Map<Tensor, RelaxedPriorityQueue> map;

  public DomainQueueMapRender(Map<Tensor, RelaxedPriorityQueue> map, Tensor eta) {
    super(Tensor.of(map.keySet().stream().map(Extract2D.FUNCTION).distinct()), eta);
    this.map = map;
  }

  @Override
  public Color color(Tensor key) {
    return INTERIOR.getColor(map.get(key).collection().size() - 1);
  }
}
