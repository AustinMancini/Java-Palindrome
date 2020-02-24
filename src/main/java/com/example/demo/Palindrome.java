package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Palindrome implements CommandLineRunner {

	private RestService restService;

	public Palindrome(RestService restService) {
		this.restService = restService;
	}

	@Override
	public void run(String... args) throws Exception {
		// Fetch posts as object
		for (Post post: restService.getPostsAsObject()) {
			String customerName = post.name;
			String[] strArray = customerName.split("");
			List<String> list = Arrays.asList(strArray);
			list = list.subList(1, list.size());

			// No Set duplicates.
			Set<String> palindromeSet = new HashSet<>(list);

			for(int i = 0; i<list.size(); i++){
				String palindromeStr = list.get(i);
				for(int j = i+1;j<list.size();j++){
					palindromeStr = palindromeStr+list.get(j);
					if(isPalindrome(palindromeStr)){
						palindromeSet.add(palindromeStr);
					}
				}
			}

			int palinSize = palindromeSet.size();
			System.out.println("{" +
					"name: " + customerName +
					", count: " + palinSize +
					'}');
		}
	}

	static boolean isPalindrome(String str){
		char[] chars = str.toCharArray();
		for(int i =0;i<(chars.length/2);i++){
			if(chars[i] != chars[chars.length-1-i]){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SpringApplication.run(Palindrome.class, args);
	}
}