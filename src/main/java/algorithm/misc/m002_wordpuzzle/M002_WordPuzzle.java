package algorithm.misc.m002_wordpuzzle;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lixl on 5/31/14.
 */
public class M002_WordPuzzle {
    ArrayList<String> res = new ArrayList<>();
    private HashMap<String, Boolean>[] dictionaries = null;
    private StringBuffer strBuffer = new StringBuffer();

    public void buildDictionaries(String filePath) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(filePath, "r");
        try {
            FileChannel inChannel = aFile.getChannel();

            Charset ascii = Charset.forName(StandardCharsets.US_ASCII.name());
            try {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (inChannel.read(buffer) > 0) {
                    buffer.flip();

                    CharBuffer charBuf = ascii.decode(buffer);

                    strBuffer.append(charBuf.array());

                    handleChunkContent(false);

                    buffer.clear();
                }

                handleChunkContent(true);
            } finally {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    //don't really care
                }
            }
        } finally {
            try {
                aFile.close();
            } catch (IOException e) {
                //don't really care.
            }
        }

    }

    private void handleChunkContent(boolean last) {
        String chunkStr = strBuffer.toString();
        int charLen = chunkStr.length();
        strBuffer.delete(0, charLen);
        String[] words = chunkStr.split("\\s");

        if (last) {
            addToDictionaries(words, words.length);
        } else {
            char lastChar = chunkStr.charAt(chunkStr.length() - 1);
            if (isWhiteSpace(lastChar)) {
                addToDictionaries(words, words.length);
            } else {
                addToDictionaries(words, words.length - 1);
                strBuffer.append(words[words.length - 1]);
            }
        }
    }

    private void addToDictionaries(String[] words, int length) {
        for (int i = 0; i < length; i++) {
            int wordLen = words[i].length();
            for (int j = 2; j < wordLen; j++) {
                if (dictionaries.length < j) {
                    HashMap<String, Boolean>[] newDict = new HashMap[j + 1];
                    System.arraycopy(dictionaries, 0, newDict, 0, dictionaries.length);

                    dictionaries = newDict;
                    dictionaries[j] = new HashMap<>();
                }
                dictionaries[j].put(words[i].substring(0, j), false);
            }

            if (dictionaries.length < wordLen) {
                HashMap<String, Boolean>[] newDict = new HashMap[wordLen + 1];
                System.arraycopy(dictionaries, 0, newDict, 0, dictionaries.length);

                dictionaries = newDict;
                dictionaries[wordLen] = new HashMap<>();
            }

            dictionaries[wordLen].put(words[i], true);
        }
    }

    private boolean isWhiteSpace(char lastChar) {
        return true;
    }

    public void play(Board board) {
        int[] sizes = board.getSizes();
        for (int x = 0; x < sizes[0]; x++) {
            for (int y = 0; y < sizes[1]; y++) {
                for (Board.DIRECT direct : Board.DIRECT.values()) {
                    Board.BoardIterator iterator = board.iterator(x, y);
                    StringBuilder strBu = new StringBuilder();

                    boolean hope = true;
                    if (hope && iterator.hasNext(direct)) {
                        char ch = iterator.next(direct);
                        String str = strBu.append(ch).toString();
                        if (str.length() < dictionaries.length) {
                            Boolean isWord = dictionaries[str.length()].get(str);

                            hope = isWord != null;
                            if (hope) {
                                if (isWord) {
                                    res.add(str);
                                }
                            }
                        }
                    }
                }
            }

        }

    }

}
