package main;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;

public class NeuralNetwork {

    ArrayList<RealMatrix> layers;
    ArrayList<RealMatrix> biases;

    public NeuralNetwork(String config) {
        String [] list = config.split(";");
        layers = new ArrayList<>();
        biases = new ArrayList<>();
        NormalDistribution nd = new NormalDistribution(0.0, 0.01);

        for(int i = 1; i<list.length; i++) {
            int row = Integer.parseInt(list[i]);
            int column = Integer.parseInt(list[i-1]);

            RealMatrix rm = MatrixUtils.createRealMatrix(row, column);
            RealMatrix bias = MatrixUtils.createRealMatrix(row, 1);

            for(int k = 0; k<row; k++) {
                bias.setEntry(k, 0, nd.sample());

                for(int j = 0; j<column; j++) {
                    rm.setEntry(k, j, nd.sample());
                }
            }

            layers.add(rm);
            biases.add(bias);

        }
    }



    public static void main(String[] args) {
        NeuralNetwork nn = new NeuralNetwork("2;5;3;2");
    }





}
