(ns novel-browser.event.core
  (:require [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [re-frame.core :as re-frame]
            [novel-browser.config :as config]
            [novel-browser.db :as db]))

(defn validate [spec db]
  (when config/debug?
    (when-let [error (s/explain-data spec db)]
      (throw (ex-info (str "DB spec validation failed: "
                           (expound/expound-str spec db))
                      error)))))

(def validate-interceptor (re-frame/after (partial validate ::db/db)))

(re-frame/reg-event-db
  ::initialize-db
  (fn [_ _]
    db/default-db))

(re-frame/reg-event-db
  ::set-active-panel
  (fn [db [_ active-panel]]
    (assoc db :active-panel active-panel)))
