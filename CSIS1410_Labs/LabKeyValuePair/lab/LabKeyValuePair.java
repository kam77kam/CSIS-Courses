/*Assignment: package labkeyvaluepair;
Program: LabKeyValuePair
Created: Mar 28, 2019
Author: %{user}
*/
package lab;

public class LabKeyValuePair <K, V> {
	
	//fields
	/**
	 * key for searching for key word
	 */
	private K key;
	/**
	 * value for returning after key word
	 */
	private V value;



	//Constructors
	/**
	 * @param key
	 * @param value
	 */
	public LabKeyValuePair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	
	
	//Methods
	//Class K getters and setters
	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}
	//Class V getters and setters
	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}
	
	
	
	//Overrides
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LabKeyValuePair other = (LabKeyValuePair) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("(%s, %s)", key, value);
	}
}
