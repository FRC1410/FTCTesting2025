package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "sensor_LimSwitch", group = "Sensor")
public class sensors_LimSwitch extends OpMode {

    // Create LED object
    RevBlinkinLedDriver blinkinLedDriver;

    // Create pattern for LED
    RevBlinkinLedDriver.BlinkinPattern pattern;

    // Declare the DigitalChannel object for the limit switch
    private DigitalChannel limitSwitch;

    @Override
    public void init() {
        // Initialize the limit switch from the hardware map
        limitSwitch = hardwareMap.get(DigitalChannel.class, "limitSwitch");

        // Set the limit switch as an input device
        limitSwitch.setMode(DigitalChannel.Mode.INPUT);

        // Assign the LED to the object
        blinkinLedDriver = hardwareMap.get(RevBlinkinLedDriver.class, "blinkin");
    }

    @Override
    public void loop() {
        // Read the state of the limit switch
        boolean isPressed = limitSwitch.getState(); /* (True when pressed, false when not) */
        //Error check for the LED
        if (blinkinLedDriver != null && limitSwitch != null) {
                if (isPressed) {
                    // If activated, turn green
                    pattern = RevBlinkinLedDriver.BlinkinPattern.GREEN;
                    blinkinLedDriver.setPattern(pattern);
                    System.out.println("Light GREEN");
                } else {
                    // If not activated, turn red
                    pattern = RevBlinkinLedDriver.BlinkinPattern.RED;
                    blinkinLedDriver.setPattern(pattern);
                    System.out.println("Light RED");
                }
        } else if (limitSwitch == null) {
                telemetry.addData("Limit Switch Broken, ", limitSwitch);
                telemetry.update();
        } else if (blinkinLedDriver == null) {
            telemetry.addData("LED Broken, ", blinkinLedDriver);
            telemetry.update();
        }
    }
}
