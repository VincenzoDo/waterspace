package ui;

//Vince
public interface Command {
	//public AbstractWorld unnamed_WorldManager_;

	public void execute();

	public void undo();
}