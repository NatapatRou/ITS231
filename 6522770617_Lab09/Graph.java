package Lab09;

/**
 * Represents a generic directed graph using an adjacency list.
 *
 * @param <T> The type of data stored in the vertices of the graph.
 */
public class Graph<T> {
	/**
	 * Represents the first adjacency list in the graph.
	 */
	AdjList<T> firstList;

	/**
	 * The count of vertices in the graph.
	 */
	int vertexCount;

	/**
	 * The count of edges in the graph.
	 */
	int edgeCount;

	/**
	 * Represents the last adjacency list in the graph.
	 */
	AdjList<T> lastList;

	/**
	 * Represents a node in the adjacency list of a directed graph.
	 *
	 * @param <T> The type of data stored in the vertex.
	 */
	private class AdjList<T> {
		/**
		 * Reference to the next adjacency list in the graph.
		 */
		AdjList<T> nextList;

		/**
		 * The data stored in the vertex.
		 */
		T data;

		/**
		 * The number of outgoing edges (outdegree) from this vertex.
		 */
		int outdegree;

		/**
		 * Reference to the first member (edge) in the adjacency list.
		 */
		Member<T> firstMember;

		/**
		 * Constructs an empty adjacency list node.
		 */
		AdjList() {
		}

		/**
		 * Constructs an adjacency list node with the specified data.
		 *
		 * @param newVertex The data for the vertex.
		 */
		AdjList(T newVertex) {
			data = newVertex;
		}
	}

	/**
	 * Represents a member of an adjacency list in a graph.
	 *
	 * @param <T> The type of the adjacency vertex.
	 */
	private class Member<T> {
		/**
		 * The adjacent vertex connected by this member.
		 */
		T adjVertex;

		/**
		 * The weight associated with the connection to the adjacent vertex.
		 */
		int weight;

		/**
		 * The next member in the adjacency list.
		 */
		Member<T> nextMember;

		/**
		 * Default constructor for the member.
		 */
		Member() {
		}

		/**
		 * Parameterized constructor for the member.
		 *
		 * @param toV    The adjacent vertex.
		 * @param weight The weight of the connection to the adjacent vertex.
		 */
		Member(T toV, int weight) {
			adjVertex = toV;
			this.weight = weight;
		}
	}

	/**
	 * Inserts a new vertex into the graph.
	 *
	 * @param newVertex The new vertex to be inserted.
	 */
	void insertVertex(T newVertex) { // Exercise 1

		// A temporary adjacency list representing the new vertex.
		AdjList<T> temp = new AdjList<T>();

		// Set the data of the temporary adjacency list to the new vertex.
		temp.data = newVertex;
		temp.outdegree = 0;

		if (vertexCount == 0) { // graph is empty
			// TODO: add your code here
			this.firstList = temp;
			this.lastList = temp;
		} else {
			// TODO: add your code here
			this.lastList.nextList = temp;
			this.lastList = temp;
		}
		vertexCount++;
	}

	/**
	 * Searches for an adjacency list in the graph containing the specified data.
	 *
	 * @param data The data to be searched for in the adjacency lists.
	 * @return The adjacency list containing the specified data, or null if not
	 *         found.
	 */
	AdjList<T> searchAdjList(T data) { // Exercise 2

		// The current adjacency list being examined, starting from the first adjacency
		// list.
		AdjList<T> current = firstList;

		while (current != null) {
			// TODO: add your code here
			if (current.data == data)
			{
				return current;
			}
			else
			{
				current = current.nextList;
			}
		}
		return null;
	}

	/**
	 * Inserts a directed edge with a specified weight from one vertex to another in
	 * the graph.
	 *
	 * @param fromData The data of the vertex from which the edge starts.
	 * @param toData   The data of the vertex to which the edge is directed.
	 * @param weight   The weight of the edge.
	 */
	void insertEdge(T fromData, T toData, int weight) { // Exercise 3 (Assume that fromData and toData exist in the
														// graph)
		// The adjacency list corresponding to the vertex from which the edge starts.
		AdjList<T> fromAdjList = searchAdjList(fromData);

		// Creates a new member (edge) with the specified destination vertex and weight
		Member<T> newMember = new Member<T>(toData, weight);

		// TODO: add your code here
		newMember.nextMember = fromAdjList.firstMember;
		fromAdjList.firstMember = newMember;
		fromAdjList.outdegree++;
		this.edgeCount++;
	}

	/**
	 * Deletes the directed edge from one vertex to another in the graph.
	 *
	 * @param fromData The data of the vertex from which the edge starts.
	 * @param toData   The data of the vertex to which the edge is directed.
	 */
	void deleteEdge(T fromData, T toData) { // Exercise 4

		// The adjacency list corresponding to the vertex from which the edge starts.
		AdjList<T> fromAdjList = searchAdjList(fromData);

		if (fromAdjList == null)
			return;

		if (fromAdjList.firstMember != null && toData.equals(fromAdjList.firstMember.adjVertex)) { // want to remove first member
			// TODO: add your code here
			fromAdjList.firstMember = fromAdjList.firstMember.nextMember;
			fromAdjList.outdegree--;
			this.edgeCount--;
		} else if (fromAdjList.firstMember != null && !toData.equals(fromAdjList.firstMember.adjVertex)) { // member that want to remove is not a first member.
			Member<T> temp = fromAdjList.firstMember;
			while (temp != null && temp.nextMember != null) {
				// TODO: add your code here
				if (toData == temp.nextMember.adjVertex) // if data that want to remove is next member , current member = next of next member.
				{
					temp.nextMember = temp.nextMember.nextMember;
					fromAdjList.outdegree--;
					this.edgeCount--;
					
				
				}
				else // if data that want to remove is not next member , current member is next member
				{
					temp = temp.nextMember;
				}
				
			}
		}
		
	}

	/**
	 * Deletes a vertex from the graph, including all edges connected to it.
	 *
	 * @param vertex The data of the vertex to be deleted.
	 */
	void deleteVertex(T vertex) { // Exercise 5

		// The current adjacency list being processed.
		AdjList<T> currentAdjList = firstList;

		// The previous adjacency list before the current one.
		AdjList<T> prevAdjList = firstList;

		while (currentAdjList != null) {
			if (!currentAdjList.data.equals(vertex)) { // if current vertex is not vertex that we want to delete.
				// TODO: add your code here
				deleteEdge(currentAdjList.data, vertex);
				prevAdjList = currentAdjList;
				currentAdjList = currentAdjList.nextList;
			} else {
				if (currentAdjList == firstList) {
					firstList = currentAdjList.nextList;
				} else if (currentAdjList == lastList) {
					// TODO: add your code here
					this.lastList = prevAdjList;
					this.lastList.nextList = null;
					
//					AdjList<T> temp = firstList;
//					while (!temp.nextList.equals(currentAdjList))
//					{
//						temp = temp.nextList;
//					}
					
				} else { // current is vertex that we want to delete
					// TODO: add your code here
//					int buffEdges = currentAdjList.outdegree;
					this.edgeCount -= currentAdjList.outdegree;
					this.vertexCount--;
					prevAdjList.nextList = currentAdjList.nextList;
					currentAdjList = currentAdjList.nextList;
					
				}
		
				
			}
		}
	}

	/**
	 * Prints the graph by displaying each vertex along with its connected vertices <br>
	 * and edge weights. The format of the output is as follows: <br>
	 * Vertex1 --> ConnectedVertex1,Weight1 --> ConnectedVertex2,Weight2 --> ... <br>
	 * Vertex2 --> ... <br>
	 * ... <br>
	 * The graph's vertex and edge counts are also displayed at the end.
	 */
	void print() {
		AdjList<T> currentList = firstList;
		while (currentList != null) {
			System.out.print(currentList.data);
			Member<T> cMem = currentList.firstMember;
			while (cMem != null) {
				System.out.print("-->" + cMem.adjVertex);
				System.out.print("," + cMem.weight);
				cMem = cMem.nextMember;
			}
			System.out.println("");
			currentList = currentList.nextList;

		}
		System.out.println("The graph consists of " + vertexCount + " vertices " + "and " + edgeCount + " edges.");
	}
}