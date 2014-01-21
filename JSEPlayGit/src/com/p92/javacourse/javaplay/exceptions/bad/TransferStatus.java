/**
 * 
 */
package com.p92.javacourse.javaplay.exceptions.bad;

/**
 * Enum for representing the different result outcome of bank transfers 
 * @author BagyuraI
 */
public enum TransferStatus
{
	/**
	 * Successful transfer
	 */
	SUCCESSFUL,
	/**
	 * Unsucessful transfer that indicates that there is not
	 * enough money on the source account.
	 */
	INSUFFICIENT_FUND,
}
