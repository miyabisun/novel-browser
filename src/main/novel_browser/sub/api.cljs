(ns novel-browser.sub.api
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
  ::favorites
  (fn [db]
    (-> db :api :favorites)))
