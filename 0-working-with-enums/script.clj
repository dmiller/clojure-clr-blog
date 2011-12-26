;; Accessing enum values

(import 'System.IO.FileMode) ;=> System.IO.FileMode
FileMode/CreateNew           ;=> CreateNew

(class FileMode/CreateNew) ;=> System.IO.FileMode

(int FileMode/CreateNew) ;=> 1


;; Creating enum values

(Enum/ToObject FileMode 4) ;=> OpenOrCreate

(enum-val FileMode "CreateNew") ;=> CreateNew
(enum-val FileMode :CreateNew) ;=> CreateNew


;; bit-field operations

(import 'System.IO.FileShare)
(enum-or FileShare/Read FileShare/Write) ;=> ReadWrite

(def r (enum-or FileShare/ReadWrite FileShare/Inheritable))
(= (enum-and r FileShare/Write) FileShare/Write) ;=> true
(= (enum-and r FileShare/Write) FileShare/None) ;=> false
(= (enum-and r FileShare/Delete) FileShare/None) ;=> true

(.HasFlag r FileShare/Write) ;=> true
(.HasFlag r FileShare/Delete) ;=> false