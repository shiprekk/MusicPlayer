package music_player;

public class MusicList {
	
	class Node{  
        Song a;  
        Node previous;  
        Node next;  
          
        public Node(Song a) {  
            this.a=a;  
        }  
    }  
	
	 Node head, tail = null; 
	 
	 private int size;
	 
	 Node current;
	 
	 public int getSize() {
		 return size;
	 }
	 
	 public void next() {
		 if(current.next==null) {
			 this.current=head;
		 }
		 this.current=current.next;
	 }
	 
	 public void prev() {
		 if(current.previous==null) {
			 this.current=tail;
		 }
		 this.current=current.previous;
	 }
	 
	 public boolean setCurrent(Node n) {
		 Song s = n.a;
		 Node search=head;
		 if(search==null) {
			 System.out.println("List is empty");
			 return false;
		 }
		 while(search!=null) {
			 Song search1=search.a;
			 if(search1.equals(s)) {
				 this.current=search;
				 return true;
			 }
			 search=search.next;
		 }
		 return false;
	 }
	 
	 public boolean setCurrent(Song key) {
		 if(!isEmpty()) {
			 Node search=head;
			 while(search!=null) {
				 Song s = search.a;
				 if(key.equals(s)) {
					 this.current=search;
					 return true;
				 }
				 search=search.next;
			 }
		 }
		 return false;
	 }
	 
	 
	 public boolean isEmpty() {
		 if(head==null) {
			 return true;
		 }
		 return false;
	 }
	 
	 public void addNode(Song a) {  
	        //Create a new node  
	        Node newNode = new Node(a);  
	          
	        //If list is empty  
	        if(head == null) {  
	            //Both head and tail will point to newNode  
	            head = tail = newNode;  
	            //head's previous will point to null  
	            head.previous = null;  
	            //tail's next will point to null, as it is the last node of the list  
	            tail.next = null;
	            size++;
	        }  
	        else {  
	            //newNode will be added after tail such that tail's next will point to newNode  
	            tail.next = newNode;  
	            //newNode's previous will point to tail  
	            newNode.previous = tail;  
	            //newNode will become new tail  
	            tail = newNode;  
	            //As it is last node, tail's next will point to null  
	            tail.next = null;
	            size++;
	        } 
	    }
	 
	 public void playNext(Song a) {
		 Node newNode = new Node(a);
		 Node current = this.current;
		 Node OldCNext = current.next;
		 current.next=newNode;
		 OldCNext.previous=newNode;
	 }
	 
	 public void playLast(Song a) {
		 Node newNode = new Node(a);
		 //newNode will be added after tail such that tail's next will point to newNode  
            tail.next = newNode;  
            //newNode's previous will point to tail  
            newNode.previous = tail;  
            //newNode will become new tail  
            tail = newNode;  
            //As it is last node, tail's next will point to null  
            tail.next = null;
            size++;
	 }
	 
	 public Song remove(Song a) {
			if(getSize()>0) {
				Node current = head;
				while(current!=null) {
					Song inList = current.a;
					if(inList.equals(a)) {
						//Unlinking(removing) node
						Node cPrevious = current.previous;
						Node cNext = current.next;
						cPrevious.next=cNext;
						cNext.previous=cPrevious;
						size--;
						return inList;
					}
					current=current.next;
				}
			}
			return null;
		}
	 
	 public boolean hasSong(Song s) {
		 if(head!=null) {
			 Node current=head;
			 while(current!=null) {
				 if(current.a.equals(s)) {
					 return true;
				 }
				 current=current.next;
			 }
		 }
		 return false;
	 }


}
