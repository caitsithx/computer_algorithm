package algorithm.puzzle100.struct;
public class TreeNode {
      /**
    * @param p_value
    * @param p_left
    * @param p_right
    */
   public TreeNode(int p_value, TreeNode p_left, TreeNode p_right) {
      super();
      this.m_value = p_value;
      this.m_left = p_left;
      this.m_right = p_right;
   }

      /**
    * @param p_value
    */
   public TreeNode(int p_value) {
      super();
      this.m_value = p_value;
   }

      private TreeNode m_left;
      private TreeNode m_right;
      
      private int m_value;

      /**
       * @return the previous
       */
      public TreeNode getLeft() {
         return this.m_left;
      }

      /**
       * @param p_previous the previous to set
       */
      public void setLeft(TreeNode p_previous) {
         this.m_left = p_previous;
      }

      /**
       * @return the next
       */
      public TreeNode getRight() {
         return this.m_right;
      }

      /**
       * @param p_next the next to set
       */
      public void setRight(TreeNode p_next) {
         this.m_right = p_next;
      }

      /**
       * @return the value
       */
      public int getValue() {
         return this.m_value;
      }

      /**
       * @param p_value the value to set
       */
      public void setValue(int p_value) {
         this.m_value = p_value;
      }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	   return "TreeNode [m_value=" + this.m_value + ",\n----------m_left=" + this.m_left
		   + ",\n----------m_right=" + this.m_right + "]";
	}
      
   }