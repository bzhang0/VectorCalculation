// BEN ZHANG
// OCTOBER 14, 2018

// THIS PROGRAM WILL CALCULATE THE RESULTANT OF X AMOUNT OF VECTORS
// USING THE COMPONENT METHOD

// THIS CODE IS ASSUMING THE USER FOLLOWS ALL THE GUIDELINES OF THE CODE
// IT IS NOT DUMMY-PROOF

import com.sun.istack.internal.FinalArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class VectorCalculation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("How many vectors do you want to compute? ");
        int answer = console.nextInt();

        // final x displacement
        double xFinal = 0;

        // final y displacement
        double yFinal = 0;

        for (int i = 1; i <= answer; i++) {
            // multipliers to find the direction of the vector
            int xMultiplier = 1;
            int yMultiplier = 1;

            System.out.println("Vector #" + i);

            // degrees of the vector
            System.out.print("Degrees: ");
            double degrees = console.nextDouble();

            // direction of the vector (corresponds with multipliers)
            // default direction is NE (1st quadrant)
            String[] directions = {"NE", "NW", "SW", "SE"};
            System.out.print("Direction " + Arrays.toString(directions) + ": ");
            String result = console.next();

            // if its going west, its going backwards on the x axis,
            // and as a result the x component is given a negative value
            if (result.contains("W")) {
                xMultiplier *= -1;
            }

            // if its going south, its going down on the y axis,
            // and as a result the y component is given a negative value
            if (result.contains("S")) {
                yMultiplier *= -1;
            }

            // gathering the hypotenuse of the vector, so the
            // x component and y component can be calculated
            System.out.print("Length of Vector: ");
            double hypotenuse = console.nextDouble();

            // calculating the x component
            double xComponent = hypotenuse * Math.cos(Math.toRadians(degrees)) * yMultiplier;

            // calculating the y component
            double yComponent = hypotenuse * Math.sin(Math.toRadians(degrees)) * xMultiplier;

            // adding the x component to the total vector x displacement
            xFinal += xComponent;

            // adding the y component to the total vector y displacement
            yFinal += yComponent;

            System.out.println();
        }

        // calculating the hypotenuse of the resultant vector with
        // the total x displacement along with the y displacement
        // using the pythagorean theorem
        double finalResult = Math.sqrt(Math.pow(xFinal, 2) + Math.pow(yFinal, 2));
        finalResult = Math.ceil((finalResult - (finalResult % 0.01)) * 100.0) / 100.0;

        // finding the final direction of the resultant vector
        String finalDirection = "";
        if (yFinal > 0) { // North
            finalDirection += "N";
        } else { // South
            finalDirection += "S";
        }

        if (xFinal > 0) { // East
            finalDirection += "E";
        } else { // West
            finalDirection += "W";
        }

        // calculating final angle of the vector and rounding it
        double finalAngle = Math.toDegrees(Math.atan2(Math.abs(yFinal), Math.abs(xFinal)));
        System.out.println(finalAngle);
        finalAngle = Math.ceil((finalAngle - (finalAngle % 0.01)) * 100.0) / 100.0;

        // rounding xFinal and yFinal to 2 decimal places
        xFinal = Math.ceil((xFinal - (xFinal % 0.01)) * 100.0) / 100.0;
        yFinal = Math.ceil((yFinal - (yFinal % 0.01)) * 100.0) / 100.0;

        // printing results
        System.out.println("X Displacement: " + xFinal);
        System.out.println("Y Displacement: " + yFinal);
        System.out.println("Vector: " + finalResult + " " + finalDirection);
        System.out.println("Angle: " + finalAngle);

    }
}
