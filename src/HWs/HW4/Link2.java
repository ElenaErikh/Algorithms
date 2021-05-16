package HWs.HW4;

import java.util.Objects;

public class Link2<T>{
        public Link2<T> prev;
        public T value;
        public Link2<T> next;

        public Link2<T> getPrev() {
                return prev;
        }

        public T getValue() {
                return value;
        }

        public Link2<T> getNext() {
                return next;
        }

//        @Override
//        public boolean equals(Object o) {
//                if (this == o) return true;
//                if (o == null || getClass() != o.getClass()) return false;
//                Link2<?> link2 = (Link2<?>) o;
//                return Objects.equals(prev, link2.prev) &&
//                        Objects.equals(value, link2.value) &&
//                        Objects.equals(next, link2.next);
//        }
//
//        @Override
//        public int hashCode() {
//                return Objects.hash(prev, value, next);
//        }
}