package com.dengzhili.Introduction;

/**
 * 斐波那契堆
 */
public class FibHeap {

    private int keyNum;     //堆中节点的总数
    private  FibNode min;      //最小节点（某个最小堆的根结点）

    private class FibNode {
        int key;    //关键字(键值)
        int degree; //度数
        FibNode left;   //左兄弟
        FibNode right;  //右兄弟
        FibNode child;  //第一个孩子节点
        FibNode parent; //父节点
        boolean marked; //是否被删除第一个孩子


        public FibNode(int key) {
            this.key = key;
            this.degree=0;
            this.marked=false;
            this.left=this;
            this.right=this;
            this.parent=null;
            this.child=null;
        }

    }
    /**
     *  将node堆节点加入root节点之前（循环链表中）
     * @param node
     * @param root
     */
    private void addNode(FibNode node,FibNode root){
        node.left=root.left;
        root.left.right=node;
        node.right=root;
        root.left=node;
    }

    /**
     * 将节点node插入到斐波那契堆中
     * @param node
     */
    public void insert(FibNode node){
        if(keyNum == 0){
            min=node;
        }else{
            addNode(node,min);
            if(node.key<=min.key){
                min=node;
            }
        }
        keyNum++;
    }

    /**
     * 新建键值为key的节点，并将其插入到斐波那契堆中
     * @param key
     */
    public void insert(int key){
        FibNode node=new FibNode(key);
        insert(node);
    }

    /**
     * 将双向链表a链接到双向链表b后面
     * @param a
     * @param b
     */
    private void catList(FibNode a,FibNode b){
        FibNode temp;
        temp= a.right;
        a.right=b.right;
        b.right.left=a;
        b.right=temp;
        temp.left=b;
    }

    /**
     * 将other合并到当前堆中
     * @param other
     */
    public void union(FibHeap other){
        if (other==null){
            return;
        }
        if(this.min==null){         //this无"最小节点"
            this.min=other.min;
            this.keyNum=other.keyNum;
            other=null;
        }else if(other.min==null){  // this有"最小节点" && other无"最小节点"
            other=null;
        }else {
            catList(this.min,other.min);
            if(this.min.key>other.min.key){
                this.min.key=other.min.key;
            }
            this.keyNum+=other.keyNum;
            other=null;
        }

    }

    /**
     * 将node链接到root根结点
     * @param node
     * @param root
     */
    private void link(FibNode node,FibNode root){

        //将node从双链表中移除
        removeNode(node);
        //将node设为root的孩子
        if(root.child==null){
            root.child=node;
        }else{
            addNode(node,root.child);
        }
        node.parent=root;
        root.degree++;
        node.marked=false;
    }

    public void removeMin(){
        if(min==null){
            return;
        }

        FibNode m=min;
        //将min每一个儿子（儿子和儿子的兄弟）添加到根链表
        while(m.child!=null){
            FibNode child=m.child;
            removeNode(child);
            if(child.right==child){
                m.child=null;
            }else{
                m.child=child.right;
            }
            addNode(child,min);
            child.parent=null;
        }

        //将m从根链表中移除
        removeNode(m);
        //若m是堆中唯一节点，则设置堆的最小节点为null
        //否则，设置堆的最小节点为一个非空节点（m.right）,然后进行调节


        if(m.right==m){
            min=null;
        }else{
            min=m.right;
            consolidate();
        }
        keyNum--;
        m=null;
    }

    /**
     * 合并斐波那契堆的根链表中左右相同度数的树
     */
    private void consolidate() {
        //获得斐波那契堆的最大度数
        int maxDegree=(int)Math.floor(Math.log(keyNum) / Math.log(2.0));
        int D=maxDegree+1;

        System.out.println("keyNum:"+keyNum+" \tD:"+D);
        FibNode[] cons=new FibNode[D+1];

        for (int i=0;i<cons.length;i++){
            cons[i]=null;
        }
        //合并相同度的根结点，使每个度数的树唯一
        while (min!=null){
            FibNode x=extractMin();
            int d=x.degree;
            while (cons[d]!=null){
                FibNode y=cons[d];
                if(x.key>y.key){    //保证x的键值比y小
                    FibNode tmp=y;
                    y=x;
                    x=tmp;
                }
                link(y,x);      //将y链接到x中
                cons[d]=null;
                d++;
            }
            cons[d]=x;
        }

        min=null;

        //将cons中的节点重新加到根表中

        for(int i=0;i<D;i++){
            if(cons[i]!=null){
                if(min==null){
                    min=cons[i];
                }else{
                    addNode(cons[i],min);
                    if(cons[i].key<min.key){
                        min=cons[i];
                    }
                }
            }
        }
    }

    /**
     * 将"堆的最小节点"从根链表中移除(意味想和"将最小节点所属的树"从堆中移除)
     * @return
     */
    private FibNode extractMin() {
        FibNode p=min;
        if(p==p.right){
            min=null;
        }else {
            removeNode(p);
            min=p.right;
        }
        p.left=p.right=p;
        return p;
    }

    /**
     * 将斐波那契堆中节点node的值减少到为key
     * @param node
     * @param key
     */
    public void decrease(FibNode node,int key){
        if(min==null || node==null){
            return;
        }

        if(key>node.key){
            System.out.printf("decrease failed: the new key(%d) is no smaller than current key(%d)",key,node.key);
            return;
        }

        FibNode parentNode=node.parent;
        node.key=key;
        if(parentNode!=null&&(node.key<parentNode.key)){
            //将node从父节点parentNode中剥离出来，并将node添加到根链表中
            cut(node,parentNode);
            cascadingCut(parentNode);
        }
        if(node.key<min.key){
            min=node;
        }
    }

    /**
     * 对节点node进行"级联剪切"
     *
     * 级联剪切：如果减小后的节点破坏了最小堆的性质
     * 则把它切下来（即从所在双链表中删除，并将其插入到由最小树根节电形成的双向链表中）
     * 然后再从"被切节点的父节点"到所在树根结点递归执行级联剪枝
     * @param node
     */
    private void cascadingCut(FibNode node) {
        FibNode parent=node.parent;
        if(parent!=null){
            if(node.marked==false)
                node.marked=true;
            else {
                cut(node,parent);
                cascadingCut(parent);
            }
        }

    }

    /**
     * 将node从父节点parent的子链接中剥离出来
     * 并使node成为"堆的根链表"中的一员
     * @param parentNode
     */
    private void cut(FibNode node, FibNode parentNode) {
        remove(node);
        renewDegree(parentNode,node.degree);
        //node没有兄弟
        if(node.right==node){
            parentNode.child=null;
        }else {
            parentNode.child=node.right;
        }
        node.parent=null;
        node.left=node.right=node;
        node.marked=false;
        //将"node所在的树"添加到"根链表"中
        addNode(node,min);
    }

    /**
     * 修改度数
     * @param parentNode
     * @param degree
     */
    private void renewDegree(FibNode parentNode, int degree) {
        parentNode.degree=parentNode.degree-degree;
        if(parentNode.parent!=null){
            renewDegree(parentNode.parent,degree);
        }

    }

    /**
     * 将斐波那契堆中节点node的值增加为key
     * @param node
     * @param key
     */
    public void increase(FibNode node,int key){
        if(min==null ||node==null){
            return;
        }
        if ( key <= node.key) {
            System.out.printf("increase failed: the new key(%d) is no greater than current key(%d)\n", key, node.key);
            return ;
        }

        //将node每一个儿子（不包含孙子，重孙子。。。）都添加到根链表中
        while (node.child!=null){
            FibNode child=node.child;
            removeNode(child);
            if(child.right==child){
                node.child=null;
            }else{
                node.child=child.right;
            }
            addNode(child,min);
            child.parent=null;
        }
        node.key=key;
        node.degree=0;

        /**
         *  如果node不在根链表中，
         *  则将node从父节点parent的子链表后者难过剥离出来
         *  并使node成为"堆的根链表"的一员
         *
         *  否则，判断是否需要根系堆的最小节点
         */
        FibNode parentNode=node.parent;
        if(parentNode!=null){
            cut(node,parentNode);
            cascadingCut(parentNode);
        }else if(min==node){
            FibNode rightNode=node.right;
            while (rightNode!=null){
                if(node.key<min.key){
                    min=node;
                }
                rightNode=rightNode.right;
            }
        }
    }

    /**
     * 删除节点node
     * @param node
     */
    private void remove(FibNode node) {
        int m=min.key;
        decrease(node,m-1);
        removeMin();
    }

    /**
     * 将node从双链表移除
     * @param node
     */
    private void removeNode(FibNode node){
        node.left.right=node.right;
        node.right.left=node.left;
    }

    /**
     * 更新斐波那契堆的节点node的键值为key
     * @param node
     * @param key
     */
    public void update(FibNode node,int key){
        if(key<node.key){
            decrease(node,key);
        }else if(key>node.key){
            increase(node,key);
        }
        return;
    }

    /**
     * 更新oldKey的值为newKey
     * @param oldKey
     * @param newKey
     */
    public void update(int oldKey,int newKey){
        FibNode node=search(oldKey);
        if(node!=null){
            update(node,newKey);
        }
    }

    /**
     * 从最小堆中查找为key的节点
     * @Param root
     * @param key
     * @return
     */
    public FibNode search(FibNode root,int key) {
        FibNode tmp=root;       //临时节点
        FibNode tarNode=null;       //查找目标节点
        if(root==null){
            return null;
        }
        do {
            if(tmp.key==key){
                tarNode=tmp;
                break;
            }else{
                if((tarNode=search(tmp.child,key))!=null){
                    break;
                }
            }
            tmp=tmp.right;
        }while (tmp!=root);
        return  tarNode;
    }

    /**
     * 在斐波那契堆中查找键值为key的节点
     * @param key
     * @return
     */
    public FibNode search(int key){
        if(min==null){
            return null;
        }
        return search(min,key);
    }

    /**
     * 在斐波那契堆中是否存在键值为key的节点
     * @param key
     * @return
     */
    public boolean contains(int key){
        return search(key)!=null?true:false;
    }

    public void remove(int key){
        if(min==null){
            return;
        }
        FibNode node=search(key);
        if(node==null){
            return;
        }
        remove(node);
    }

    /**
     * 销毁斐波那契堆
     * @param node
     */
    private void destoryNode(FibNode node){
        if(node==null){
            return;
        }
        FibNode startNode=node;
        do{
            destoryNode(node.child);
            node=node.right;
            node.left=null;
        }while (node!=startNode);
    }

    /**
     * 销毁斐波那契堆
     */
    public void destory(){
        destoryNode(min);
    }

    /**
     * 参数说明：
     * @param node  当前节点
     * @param prev  当前节点的前一个节点（父节点or兄节点）
     * @param direction 1.表示当前节点是左孩子
     *                  2.表示当前节点是右兄弟节点
     */
    private void print(FibNode node,FibNode prev,int direction){
        FibNode start=node;
        if(node==null){
            return;
        }
        do{
            System.out.println("node key:"+node.key);
            System.out.println("start key:"+start.key);
            node=node.right;
        }while (node!=start);

        do{
            if(direction==1){
                System.out.printf("%8d(%d) is %2d's child\n", node.key, node.degree, prev.key);
            }else{
                System.out.printf("%8d(%d) is %2d's next\n", node.key, node.degree, prev.key);
            }
            if(node.child!=null){
                print(node.child,node,1);
            }
            //兄弟节点
            prev=node;
            node=node.right;
            direction=2;
            System.out.println("start key:"+start.key);
        }while (node!=start);
    }

    public void print(){
        if(min==null)
            return;
        int i=0;
        FibNode p=min;
        System.out.println("min:"+min.key);
        System.out.println("====== 斐波那契堆的详细信息：=========\n");
        do{
            i++;
            System.out.printf("%2d. %4d(%d) is root\n", i, p.key, p.degree);
            print(p.child,p,1);
            p=p.right;
            if(i==20)   break;
        }while (p!=min);
        System.out.println("\n");
    }


}
