package Services;

public class Item {

        private int quantity;
        private String Name;
        public Item() {}
        public Item(String Name,int quantity) {
            this.quantity = quantity;
            this.Name = Name;
        }
        public int getQuantity() {
            return quantity;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        public String getName() {
            return Name;
        }
        public void setName(String name) {
            Name = name;
        }

}
