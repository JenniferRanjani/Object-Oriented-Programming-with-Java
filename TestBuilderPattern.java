import javax.swing.JOptionPane;

class Computer {
	
	//required parameters
	private String HDD;
	private String RAM;
	
	//optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;
	

	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	private Computer(ComputerBuilder builder) {
		this.HDD=builder.HDD;
		this.RAM=builder.RAM;
		this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled=builder.isBluetoothEnabled;
	}
	
	//Builder Class
	public static class ComputerBuilder{

		// required parameters
		private String HDD;
		private String RAM;

		// optional parameters
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;
		
		public ComputerBuilder(String hdd, String ram){
			this.HDD=hdd;
			this.RAM=ram;
		}

		public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		
		public Computer build(){
			return new Computer(this);
		}

	}
}

public class TestBuilderPattern {

	public static void main(String[] args) {
		String hdd, ram;
		Boolean bt;
		hdd = JOptionPane.showInputDialog("Enter HDD size in GB");
		ram = JOptionPane.showInputDialog("Enter RAM size in GB");
		bt = Boolean.parseBoolean(JOptionPane.showInputDialog("Should Bluetooth be Enable (T/F)?"));
		
		Computer comp = new Computer.ComputerBuilder(hdd, ram).setBluetoothEnabled(bt).build();
		JOptionPane.showConfirmDialog(null, "HDD = "+comp.getHDD()+" isGraphicsCardEnabled "+ comp.isGraphicsCardEnabled());
	}

}
