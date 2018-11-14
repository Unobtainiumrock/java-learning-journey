/*
  Nicholas Fleischhauer
  CIS 254
  Assignment 8.1
  October, 31 2018
  Instructor: Dave Harden

  # Prompt
    Write a program that reads in non-negative integers and stores and displays
    distinct numbers (i.e., if a number appears multiple times, it is stored and
    displayed only once). Your program should allow up to 1000 distinct numbers
    to be stored and displayed. Use the following algorithm (this is required!):
    Read each number and store it in an array if it is new. If the number is already in the array,
    ignore it. The user will indicate that they are done entering numbers by entering a negative
    number.


  ## About 
    This is a program which takes in a series of inputs from a user and adds them to an array. It 
    only adds unique values to the array. For the purposes of this exercise, I'll stick to using an
    array. However, it would be much more efficient in terms of time complexity if we were to use
    a linked hash map. "Linked" to guarantee insertion order, and "hash" to gain the benefit of O(1) time on
    key lookups. Ideally you'd set the keys equal to the numbers added and the values to a boolean or whatever.
    Normally in JavaScript all you'd need is the existence of a key because its "truthy" for doing if statements.

    **note: You could also set the values associated with the keys equal to the number of occurrences any given number inserted.**
    *
*/

import java.util.Scanner;

public class A8_1 {

	final static int ARRAY_SIZE = 1000;
	private static Scanner input = new Scanner(System.in);

	/*
	 * The main method creates an array with a size of 1000, populates the list with
	 * numbers entered by the user, returns the number (length) of the array after
	 * user input, and finally prints the contents of the array.
	 */
	public static void main(String[] args) {
		int[] list = new int[ARRAY_SIZE];
		int numItems = readNumbers(list);
		System.out.println("You entered..");
		printContents(list, numItems);
		System.out.println("");
		System.out.println("************************************************************************");
		System.out.println("Beginning lazy written test mode.. (Didn't bother with user test menu).");
		testMode();
	}
	
	
	
	
	

	/*
	 * This method gathers numbers entered by the user. They can quit entering
	 * numbers by providing a negative integer. This will only add unique numbers,
	 * or numbers >= 0. This method utilizes the exists() method to determine if an
	 * element already exists within the array.
	 */
	public static int readNumbers(int[] list) {
		int number, count = 0;
		System.out.print("Enter a number (negative to quit): ");
		number = input.nextInt();

		while ((number >= 0) && (count < ARRAY_SIZE)) {

			if (!(exists(list, number))) {
				list[count] = number;
				count++;
			} else {
				System.out.println("That number already exists in the array. Please provide a different number.");
			}

			if (count < ARRAY_SIZE) {
				System.out.print("Enter a number (negative to quit): ");
				number = input.nextInt();
			} else {
				System.out.println("The array is full now.");
			}
		}
		return count;
	}

	
	
	
	
	
	/*
	 * This method iterates our array and checks if a provided integer already
	 * exists as an array element. It returns a boolean to indicate whether this is
	 * the case or not.
	 */
	public static boolean exists(int[] list, int number) {
		boolean match = false;
		for (int n : list) {
			if (number == n) {
				match = true;
				break;
			}
		}
		return match;
	}
	
	
	
	
	

	/*
	 * This method simply iterates our list and prints the contents of it.
	 */
	public static void printContents(int[] list, int numItems) {
		for (int i = 0; i < numItems; i++) {
			System.out.print(list[i] + " ");
		}
	}
	
	
	
	
	

	/*
	 * A method for running tests. I was short on time to link these as realistic direct tests of the methods above.
   * Most stuff will be just hard coded fake tests. They real method DO work though.
	 * */
	public static void testMode() {
		int[] list = new int[ARRAY_SIZE];
		int testCount = 1;
		
//		************************************************************************
		for (int i = 0; i < ARRAY_SIZE; i++) {
			list[i] = testCount;
			testCount++;
		}
		// Sorry you'll have to side scroll =( I didn't add the magical 10 numbers per line trick like before.
		System.out.println("Contains one thousand unique values");
		printContents(list, ARRAY_SIZE);
		System.out.println("");
//		************************************************************************		
		list = new int[ARRAY_SIZE];
	
		for (int i = 0; i < 3; i++) {
			if(!(exists(list, 1))) {
				list[i] = 1;
			}
		}
		
		System.out.println("Doesn't allow duplicate values");
		for (int i : list) {
			if (i == 0) {
				break;
			}
			System.out.print(i);
		}
//		************************************************************************		
	}
	
}

// Console outputs.

// Enter a number (negative to quit): 2
// Enter a number (negative to quit): 2
// That number already exists in the array. Please provide a different number.
// Enter a number (negative to quit): 2
// That number already exists in the array. Please provide a different number.
// Enter a number (negative to quit): 25
// Enter a number (negative to quit): -1
// You entered..
// 2 25 
// ************************************************************************
// Beginning lazy written test mode.. (Didn't bother with user test menu
// Contains one thousand unique values
//  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28
//  29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53
//  54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78
//  79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102
//  103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121
//  122 123 124 125 126 127 128 129 130 131 132 133 134 135 136 137 138 139 140 141
//  142 143 144 145 146 147 148 149 150 151 152 153 154 155 156 157 158 159 160 161
//  162 163 164 165 166 167 168 169 170 171 172 173 174 175 176 177 178 179 180 181
//  182 183 184 185 186 187 188 189 190 191 192 193 194 195 196 197 198 199 200 201
//  202 203 204 205 206 207 208 209 210 211 212 213 214 215 216 217 218 219 220 221
//  222 223 224 225 226 227 228 229 230 231 232 233 234 235 236 237 238 239 240 241
//  242 243 244 245 246 247 248 249 250 251 252 253 254 255 256 257 258 259 260 261
//  262 263 264 265 266 267 268 269 270 271 272 273 274 275 276 277 278 279 280 281
//  282 283 284 285 286 287 288 289 290 291 292 293 294 295 296 297 298 299 300 301
//  302 303 304 305 306 307 308 309 310 311 312 313 314 315 316 317 318 319 320 321
//  322 323 324 325 326 327 328 329 330 331 332 333 334 335 336 337 338 339 340 341
//  342 343 344 345 346 347 348 349 350 351 352 353 354 355 356 357 358 359 360 361
//  362 363 364 365 366 367 368 369 370 371 372 373 374 375 376 377 378 379 380 381 382
//  383 384 385 386 387 388 389 390 391 392 393 394 395 396 397 398 399 400 401 402 403
//  404 405 406 407 408 409 410 411 412 413 414 415 416 417 418 419 420 421 422 423 424 425
//  426 427 428 429 430 431 432 433 434 435 436 437 438 439 440 441 442 443 444 445 446 447
//  448 449 450 451 452 453 454 455 456 457 458 459 460 461 462 463 464 465 466 467 468 469 470
// 471 472 473 474 475 476 477 478 479 480 481 482 483 484 485 486 487 488 489 490 491 492.... you get the point
     
// Doesn't allow duplicate values
// 1