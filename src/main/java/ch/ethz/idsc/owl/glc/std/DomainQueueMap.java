// code by jph
package ch.ethz.idsc.owl.glc.std;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import ch.ethz.idsc.owl.glc.core.DomainQueue;
import ch.ethz.idsc.owl.glc.core.GlcNode;
import ch.ethz.idsc.tensor.Tensor;

/** utility collection holds candidates generated by one step of expansion
 * 
 * data structure is used during planner expansion but not for storage of nodes */
/* package */ class DomainQueueMap implements Iterable<Entry<Tensor, DomainQueue>> {
  /** map from domain keys to queues of nodes */
  final Map<Tensor, DomainQueue> map = new HashMap<>();

  /** add given glcNode to domain queue at the location determined by domain_key.
   * a new domain queue is allocated if no other nodes were inserted there prior.
   * 
   * @param domain_key
   * @param glcNode */
  public void insert(Tensor domain_key, GlcNode glcNode) {
    if (map.containsKey(domain_key)) // has another node has already reached this domain ?
      map.get(domain_key).add(glcNode); // add node to existing queue
    else
      map.put(domain_key, DomainQueue.singleton(glcNode)); // create a new empty queue
  }

  @Override // from Iterable
  public Iterator<Entry<Tensor, DomainQueue>> iterator() {
    return map.entrySet().iterator();
  }
}