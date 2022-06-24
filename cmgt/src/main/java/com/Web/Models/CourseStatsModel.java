package com.Web.Models;

public class CourseStatsModel {
	private double weightedAverage;
	private double min;
	private double max;
	private double mean;
	private double stdDeviation;
	private double variance;
	private double percentiles;
	private double skewness;
	private double kurtosis;
	private double median;
	public double getWeightedAverage() {
		return weightedAverage;
	}
	public void setWeightedAverage(double weightedAverage) {
		this.weightedAverage = weightedAverage;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public double getStdDeviation() {
		return stdDeviation;
	}
	public void setStdDeviation(double stdDeviation) {
		this.stdDeviation = stdDeviation;
	}
	public double getVariance() {
		return variance;
	}
	public void setVariance(double variance) {
		this.variance = variance;
	}
	public double getPercentiles() {
		return percentiles;
	}
	public void setPercentiles(double percentiles) {
		this.percentiles = percentiles;
	}
	public double getSkewness() {
		return skewness;
	}
	public void setSkewness(double skewness) {
		this.skewness = skewness;
	}
	public double getKurtosis() {
		return kurtosis;
	}
	public void setKurtosis(double kurtosis) {
		this.kurtosis = kurtosis;
	}
	public double getMedian() {
		return median;
	}
	public void setMedian(double median) {
		this.median = median;
	}
}
