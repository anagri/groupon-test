package com.groupon;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueueTest {
    @Test
    public void shouldConstructCircularQueueOfGivenLength() {
        Queue queue = new Queue(3).enqueue(1).enqueue(2).enqueue(3);
        assertThat(queue.dequeue(), is(1));
        assertThat(queue.dequeue(), is(2));
        assertThat(queue.dequeue(), is(3));
    }

    @Test
    public void shouldOverwriteOnQueueIfWritingMoreElementsThanRead() {
        Queue queue = new Queue(3).enqueue(1).enqueue(2).enqueue(3).enqueue(4);
        assertThat(queue.dequeue(), is(4));
    }

    @Test
    public void shouldBeAbleToReadElementsInCircularOrder() {
        Queue queue = new Queue(2).enqueue(1).enqueue(2);
        assertThat(queue.dequeue(), is(1));
        assertThat(queue.dequeue(), is(2));
        assertThat(queue.dequeue(), is(1));
    }
}
