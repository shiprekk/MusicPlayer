package music_player;



public class DLLM {
	class Node{  
        Album a;  
        Node previous;  
        Node next;  
          
        public Node(Album a) {  
            this.a=a;  
        }  
    }  
	
	
	 Node head, tail = null; 
	 
	 private int size;
	 
	 public int getSize() {
		 return size;
	 }
	 
	 
	 public void addNode(Album a) {  
	        Node newNode = new Node(a);  
	          
	        if(head == null) {  
	            head = tail = newNode;  
	            head.previous = null;  
	            tail.next = null;
	            size++;
	        }  
	        else {  
	            tail.next = newNode;  
	            newNode.previous = tail;  
	            tail = newNode;  
	            tail.next = null;
	            size++;
	        }  
	    }
	 
	 public Album remove(Album a) {
			if(getSize()>0) {
				Node current = head;
				while(current!=null) {
					Album inList = current.a;
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
	 
	 public void sortLengthDescending() {
		 Node current = null, index = null;  
		 Album temp; 
		 if(head == null) {  
			 return;  
		 }  
		 else {  
			 //Current will point to head  
			 for(current = head; current.next != null; current = current.next) {  
				 //Index will point to node next to current  
				 for(index = current.next; index != null; index = index.next) {  
					 //If current's data is greater than index's data, swap the data of current and index  
					 if(current.a.getLength() < index.a.getLength()) {  
						 temp = current.a;  
						 current.a = index.a;  
						 index.a = temp;  
					 }  
				 }  
			 }  
		 }  
	 }  
	 
	 public void sortLengthAscending() {
		 Node current = null, index = null;  
		 Album temp;  
		 if(head == null) {  
			 return;  
		 }  
		 else {  
			 for(current = head; current.next != null; current = current.next) {  
				 for(index = current.next; index != null; index = index.next) {    
					 if(current.a.getLength() > index.a.getLength()) {  
						 temp = current.a;  
						 current.a = index.a;  
						 index.a = temp;  
					 }  
				 }  
			 }  
		 }  
	 }  

}
