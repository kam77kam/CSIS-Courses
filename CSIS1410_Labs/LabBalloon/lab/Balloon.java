/*Assignment: LabQuadrotor
Program: QuadrotorApp
Created: Mar 12, 2019
Author: Kamdon Bird
*/


package lab;

import javax.swing.Icon;

public class Balloon {
	public boolean helium;
	public Size size;
	public Icon icon;
	public Balloon(boolean helium, Size size) {
		super();
		this.helium = helium;
		this.size = size;
	}
	public Balloon(boolean helium, Size size, Icon icon) {
		super();
		this.helium = helium;
		this.size = size;
		this.icon = icon;
	}
	/**
	 * @return the helium
	 */
	public boolean isHelium() {
		return helium;
	}
	/**
	 * @return the size
	 */
	public Size getSize() {
		return size;
	}
	/**
	 * @return the icon
	 */
	public Icon getIcon() {
		return icon;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (helium ? 1231 : 1237);
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Balloon other = (Balloon) obj;
		if (helium != other.helium)
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s %s", this.isHelium() ? "Helium" : "Air",
				this.getSize());
	}
}
