(ns novel-browser.db
  (:require [clojure.spec.alpha :as s]))

(s/def :db/active-panel #{:top})

(def default-db
  {:active-panel :top
   :title ""

   :alerts []
   :modal nil})
