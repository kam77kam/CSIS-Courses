/*Assignment: package labkeyvaluepair;
Program: LabKeyValuePair
Created: Mar 28, 2019
Author: Kamdon Bird
 */
package labkeyvaluepair;

public class LabKeyValuePair<K extends Comparable<K>, V> implements Comparable< LabKeyValuePair <K, V>> {
    //fields
    private K key;
    private V value;
    private int temp;
    
    /**
     * @param key
     * @param value
     */
    //Cnstr
    public LabKeyValuePair(K key, V value) {
        super();
        this.key = key;
        this.value = value;
        temp = (int) value;
    }

    //Methods
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
    public int getTemp() {
        return temp;
    }

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
    /** (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("(%s, %,d)", key, value);
    }

    @Override
    public int compareTo(LabKeyValuePair<K, V> arg0) {

        if((this.getKey()) == (arg0.getKey())) {
            return 0;
        }
        else if(((int) this.getValue()) > ((int) arg0.getValue())){
            return 1;
        }

        else {
            return -1;
        }
    }
}