//
// Coded by Prudence Wong 2021-12-29
// Updated 2023-02-26
// Updated 2023-03-03
//
// NOTE: You are allowed to add additional methods if you need.
//
// Name: Killian Carolan
// Student ID: 201823073
//
// Time Complexity and explanation: You can use the following variables for easier reference.
// n denotes the number of requests, p denotes the size of the cache
// n and p can be different and there is no assumption which one is larger
//
// Each of the methods the eviction functions use are analysed throughout the file but to summise:

// evictFIFO():
// Time Complexity: O(np)
// - Each request is checked using seqSearch() which runs in O(p) time in the worst case
// - Since we iterate over all n requests the overall complexity is O(np)
// - The FIFO update operation updateCacheFIFO() runs in O(1) time, so it doesn’t impact the complexity

// evictLRU():
// Time Complexity: O(np)
// - Each request is checked using seqSearch() which runs in O(p) time in the worst case
// - If there is a miss, updateCacheLRU() is called, which consists of:
//   - seqSearch() (O(p)) to find the element to evict
//   - Shifting elements in cacheQueue (O(p))
// - Therefore, the worst-case time complexity per request is O(p), and for n requests, the total complexity is O(np)


class COMP108Paging {
	// O(nm) where n = seqSearch and m = rSize
	static COMP108PagingOutput evictFIFO(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108PagingOutput output = new COMP108PagingOutput();
		int nextEviction = 0;

		// for every element in the requests
		for (int i = 0; i < rSize; i++) {
			// if a request is NOT a hit
			if (!seqSearch(cArray, rArray[i])) {
				output.missCount++;
				output.hitPattern += "m";
				cArray[nextEviction] = rArray[i];
				nextEviction = updateCacheFIFO(cSize, nextEviction);
			} else {
				output.hitCount++;
				output.hitPattern += "h";
			}
		}
		output.cache = arrayToString(cArray, cSize);
		return output;
	}

	// O(nm) where n = seqSearch and m = rSize
	static COMP108PagingOutput evictLRU(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108PagingOutput output = new COMP108PagingOutput();
		int[] cacheQueue = new int[cSize];

		for (int i = 0; i < cSize; i++) {
			cacheQueue[i] = cArray[i];
		}

		// for every element in the requests
		for (int i = 0; i < rSize; i++) {
			// if a request is NOT a hit
			if (!seqSearch(cArray, rArray[i])) {
				output.missCount++;
				output.hitPattern += "m";

				CacheResult updatedCache = updateCacheLRU(
					cSize, cArray, cacheQueue, rArray[i], false
					);

				cArray = updatedCache.cArray;
				cacheQueue = updatedCache.cacheQueue;

			} else {
				output.hitCount++;
				output.hitPattern += "h";

				CacheResult updatedCache = updateCacheLRU(
					cSize, cArray, cacheQueue, rArray[i], true
					);

				cArray = updatedCache.cArray;
				cacheQueue = updatedCache.cacheQueue;
			}
		}

		output.cache = arrayToString(cArray, cSize);
		return output;
	}

	// DO NOT change this method
	static String arrayToString(int[] array, int size) {
		String outString="";
		
		for (int i=0; i<size; i++) {
			outString += array[i];
			outString += ",";
		}
		return outString;
	}

	// O(n) where n = data.length
	static boolean seqSearch(int[] data, int key) {
		int i;
		boolean found;

		found = false;
		i = 0;

		while (i<data.length && found==false) {
			if (data[i] == key) {
				found = true;
			} else {
				i = i+1;
			}

		}

		return found;
	}

	// O(n) where n = data.length
	static int seqSearch(int[] data, int key, boolean pos) {
		int i;
		boolean found;

		found = false;
		i = 0;
		while (i<data.length && found==false) {
			if (data[i] == key) {
				found = true;
			} else {
				i = i+1;
			}
		}
		if (!found) {
			return -1;
		} else {
			return i;
		}
	}

	// O(1)
	static int updateCacheFIFO(int cSize, int longestRunning) {
		if (longestRunning >= cSize-1) {
			longestRunning = 0;
		} else {
			longestRunning++;
		}
		return longestRunning;
	}

	// O(n) where n = seqSearch + shift
	static CacheResult updateCacheLRU(int cSize, int[] cArray, int[] cacheQueue, int task, boolean req) {
		if (req) {
			// position of the hit
			int cacheQueuePos = seqSearch(cacheQueue, task, true);

			/* loops through the cacheQueue from the hit position onwards,
			 * shifting everything left
			 */
			for (int i = cacheQueuePos+1; i < cacheQueue.length; i++) {
				cacheQueue[i-1] = cacheQueue[i];
			}
			cacheQueue[cacheQueue.length-1] = task;
		} else {
			int evictedData = cacheQueue[0];
			int evictedDataPos = seqSearch(cArray, evictedData, true);
			cArray[evictedDataPos] = task;

			// similar method but starting from the second element
			 for (int i = 1; i < cacheQueue.length; i++) {
				cacheQueue[i-1] = cacheQueue[i];
			}
			cacheQueue[cacheQueue.length-1] = task;			
		}
		// the result is that the task is now at the back of an updated cache queue

		return new CacheResult(cArray, cacheQueue);
	}
}

// wrapper class to return both the real cache and cache queue
class CacheResult {
    int[] cArray;
    int[] cacheQueue;

    CacheResult(int[] cArray, int[] cacheQueue) {
        this.cArray = cArray;
        this.cacheQueue = cacheQueue;
    }
}
