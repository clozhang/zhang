.PHONY: docs

ROOT_DIR = $(shell pwd)
DOCS_DIR = $(ROOT_DIR)/docs
REPO = $(shell git config --get remote.origin.url)
CURRENT = $(DOCS_DIR)/current
LOCAL_DOCS_HOST = localhost
LOCAL_DOCS_PORT = 5099

pre-docs:
	@echo "\nBuilding docs ...\n"
	@lein clean

zhang-docs:
	@lein with-profile docs codox

serve-docs: docs
	@echo "\nRunning docs server on http://$(LOCAL_DOCS_HOST):$(LOCAL_DOCS_PORT)..."
	@lein simpleton $(LOCAL_DOCS_PORT) file :from $(CURRENT)

docs: pre-docs zhang-docs

publish-docs: prod-docs
	@echo "\nPublishing docs ...\n"
	@git commit $(DOCS_DIR) -m "Updated docs."
	@git push --all
