package lab;

public class Bird implements Flyable
{
	private final String type;

	public Bird(String t)
	{
		type = t;
	}

	@Override
	public String toString()
	{
		return type;
	}

	@Override
	public void launch() {
		System.out.println("Bird launch: Flapping the wings to take off");
	}

	@Override
	public void land() {
		System.out.println("Bird land: Flapping the wings until landing");
	}
}
