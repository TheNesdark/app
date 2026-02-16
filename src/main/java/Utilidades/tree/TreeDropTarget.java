package Utilidades.tree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.image.BufferedImage;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/TreeDropTarget.class */
public class TreeDropTarget extends DropTarget {
    private Rectangle lastRowBounds;
    private int insertAreaHeight = 8;
    private Insets autoscrollInsets = new Insets(20, 20, 20, 20);
    private Rectangle rect2D = new Rectangle();
    private NodeMoveTransferHandler handler;
    private Point mostRecentLocation;

    public TreeDropTarget(NodeMoveTransferHandler h) {
        this.handler = h;
    }

    public void dragOver(DropTargetDragEvent dtde) {
        JTree tree = (JTree) dtde.getDropTargetContext().getComponent();
        Point loc = dtde.getLocation();
        updateDragMark(tree, loc);
        paintImage(tree, loc);
        autoscroll(tree, loc);
        super.dragOver(dtde);
    }

    public void dragExit(DropTargetDragEvent dtde) {
        clearImage((JTree) dtde.getDropTargetContext().getComponent());
        super.dragExit(dtde);
    }

    public void drop(DropTargetDropEvent dtde) {
        clearImage((JTree) dtde.getDropTargetContext().getComponent());
        super.drop(dtde);
    }

    private final void paintImage(JTree tree, Point pt) {
        BufferedImage image = this.handler.getDragImage(tree);
        if (image != null) {
            tree.paintImmediately(this.rect2D.getBounds());
            this.rect2D.setRect(((int) pt.getX()) - 15, ((int) pt.getY()) - 15, image.getWidth(), image.getHeight());
            tree.getGraphics().drawImage(image, ((int) pt.getX()) - 15, ((int) pt.getY()) - 15, tree);
        }
    }

    private final void clearImage(JTree tree) {
        tree.paintImmediately(this.rect2D.getBounds());
    }

    private Insets getAutoscrollInsets() {
        return this.autoscrollInsets;
    }

    private void autoscroll(JTree tree, Point cursorLocation) {
        Insets insets = getAutoscrollInsets();
        Rectangle outer = tree.getVisibleRect();
        Rectangle inner = new Rectangle(outer.x + insets.left, outer.y + insets.top, outer.width - (insets.left + insets.right), outer.height - (insets.top + insets.bottom));
        if (!inner.contains(cursorLocation)) {
            Rectangle scrollRect = new Rectangle(cursorLocation.x - insets.left, cursorLocation.y - insets.top, insets.left + insets.right, insets.top + insets.bottom);
            tree.scrollRectToVisible(scrollRect);
        }
    }

    public void updateDragMark(JTree tree, Point location) {
        this.mostRecentLocation = location;
        int row = tree.getRowForPath(tree.getClosestPathForLocation(location.x, location.y));
        TreePath path = tree.getPathForRow(row);
        if (path != null) {
            Rectangle rowBounds = tree.getPathBounds(path);
            int rby = rowBounds.y;
            int topBottomDist = this.insertAreaHeight / 2;
            Point topBottom = new Point(rby - topBottomDist, rby + topBottomDist);
            if (topBottom.x <= location.y && topBottom.y >= location.y) {
                paintInsertMarker(tree, location);
            } else {
                markNode(tree, location);
            }
        }
    }

    public Point getMostRecentDragLocation() {
        return this.mostRecentLocation;
    }

    private void markNode(JTree tree, Point location) {
        TreePath path = tree.getClosestPathForLocation(location.x, location.y);
        if (path != null) {
            if (this.lastRowBounds != null) {
                Graphics g = tree.getGraphics();
                g.setColor(Color.white);
                g.drawLine(this.lastRowBounds.x, this.lastRowBounds.y, this.lastRowBounds.x + this.lastRowBounds.width, this.lastRowBounds.y);
            }
            tree.setSelectionPath(path);
            tree.expandPath(path);
        }
    }

    private void paintInsertMarker(JTree tree, Point location) {
        Graphics g = tree.getGraphics();
        tree.clearSelection();
        int row = tree.getRowForPath(tree.getClosestPathForLocation(location.x, location.y));
        TreePath path = tree.getPathForRow(row);
        if (path != null) {
            Rectangle rowBounds = tree.getPathBounds(path);
            if (this.lastRowBounds != null) {
                g.setColor(Color.white);
                g.drawLine(this.lastRowBounds.x, this.lastRowBounds.y, this.lastRowBounds.x + this.lastRowBounds.width, this.lastRowBounds.y);
            }
            if (rowBounds != null) {
                g.setColor(Color.black);
                g.drawLine(rowBounds.x, rowBounds.y, rowBounds.x + rowBounds.width, rowBounds.y);
            }
            this.lastRowBounds = rowBounds;
        }
    }
}
