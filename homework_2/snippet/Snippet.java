package snippet;

public class Snippet {
	echo "# java_code" >> README.md
	git init
	git add README.md
	git commit -m "first commit"
	git remote add origin https://github.com/scottc99/java_code.git
	git push -u origin master
}

