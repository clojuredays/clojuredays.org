release:
	boot production build target
	mkdir -p docs
	cp -rf target/* docs/

dev:
	boot dev
