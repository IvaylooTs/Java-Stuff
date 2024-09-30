public class MyStack {
    static class Node{
        private int data;
        private Node nextNode;

        public Node(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
    int length = 0;
    Node top = null;

    public MyStack(){
    }
    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }
    public void push(int data) {
        Node tempNode = new Node(data);
        tempNode.setNextNode(top);
        top = tempNode;
        length++;
    }
    public int pop() {
        if(isEmpty()){
            throw new RuntimeException("Empty stack");
        }
        Node node = top;
        top = top.getNextNode();
        length--;
        return node.getData();
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Empty stack");
        }
        return top.getData();
    }
}
