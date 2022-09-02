package lab;

public class Hangglider implements Flyable
{
	private final boolean isRigidWing;

	public Hangglider(boolean rigidWing)
	{
		isRigidWing = rigidWing;
	}

	@Override
	public String toString()
	{
		return String.format(isRigidWing ? "Rigid-wing" : "Flex-wing");
	}

	@Override
	public void launch() {
		System.out.println("Hangglider launch: Running until take-off");
	}

	@Override
	public void land() {
		System.out.println("Hangglider land: Gliding to a land");
	}
}
