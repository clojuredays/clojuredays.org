release:
	boot production build target
	mkdir -p docs
	cp -rf target/* docs/
	git add docs/
	git commit "Website updated on $(shell date)"
	git push

dev:
	boot dev
