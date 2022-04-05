package orchester;

import java.io.IOException;

public interface Verhalten {
    void spielen(Orchester orchester) throws IOException;
}
