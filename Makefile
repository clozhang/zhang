PROJ := $(strip $(word 2, $(shell grep defproject project.clj )))
PROJ_VERSION := $(strip $(subst \", , $(word 3, $(shell grep defproject project.clj ))))
CLOJURE_DEP := $(strip $(shell grep "org.clojure/clojure" project.clj))
CLOJURE_VER := $(subst ], , $(word 3, $(CLOJURE_DEP)))
JAR := $(PROJ)-$(VERSION).jar
UBERJAR := $(PROJ)-$(VERSION)-standalone.jar
LOCAL_MAVEN := ~/.m2/repository

clojars:
	@lein deploy clojars

include resources/make/docs.mk
include resources/make/test.mk
